package plugin;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This plugin adds setForUpdate(boolean) method to the example class.<br />
 * When it's enabled, 'for update' clause is appended to the select statement.
 *
 * @author Iwao AVE!
 */
public class ForUpdatePlugin extends PluginAdapter
{
    private FullyQualifiedJavaType rowBounds =
            new FullyQualifiedJavaType("org.apache.ibatis.session.RowBounds"); //$NON-NLS-1$
    private Map<FullyQualifiedTable, List<XmlElement>> elementsToAdd =
            new HashMap<FullyQualifiedTable, List<XmlElement>>();

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method,
                                                                 Interface interfaze, IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(
            Method method, Interface interfaze,
            IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
        return true;
    }

    /**
     * We'll override this method and add any new elements generated by
     * previous calls
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document,
                                           IntrospectedTable introspectedTable) {
        List<XmlElement> elements = elementsToAdd.get(introspectedTable.getFullyQualifiedTable());
        if (elements != null) {
            for (XmlElement element : elements) {
                document.getRootElement().addElement(element);
            }
        }

        return true;
    }

    @Override
    public boolean clientBasicSelectManyMethodGenerated(Method method, Interface interfaze,
                                                        IntrospectedTable introspectedTable) {

        addNewComposedFunctionForUpdate(interfaze, introspectedTable, method.getReturnType());

        return true;
    }

    private void addNewComposedFunctionForUpdate(Interface interfaze, IntrospectedTable introspectedTable, FullyQualifiedJavaType baseMethodReturnType) {
        interfaze.addImportedType(new FullyQualifiedJavaType("org.brian.dao.ext.paging.ForUpdateAdapter")); //$NON-NLS-1$
        String tableFieldName =
                JavaBeansUtil.getValidPropertyName(introspectedTable.getFullyQualifiedTable().getDomainObjectName());

        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("QueryExpressionDSL<ForUpdateAdapter<" //$NON-NLS-1$
                + baseMethodReturnType.getShortName() + ">>"); //$NON-NLS-1$


        Method method = new Method("selectWithForUpdate"); //$NON-NLS-1$
        method.setDefault(true);
        method.setReturnType(returnType);


        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            String property = column.getJavaProperty();

            if (sb.length() == 0) {
                sb.append("       ").append(property);
            }else {
                sb.append(", ").append(property);
            }
        }
        sb.append(")").append("\n");
        sb.append("               .from(").append(tableFieldName).append(");");

        method.addBodyLine("return SelectDSL.select(selectModel -> ForUpdateAdapter.of(selectModel, this::selectMany), "); //$NON-NLS-1$
        method.addBodyLine(sb.toString());

        context.getCommentGenerator().addGeneralMethodAnnotation(method, introspectedTable, interfaze.getImportedTypes());
        interfaze.addMethod(method);
    }
}
