package plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.util.Set;

public class MyCommentGenerator extends DefaultCommentGenerator {
    private static void addRemark(JavaElement element, String remarks) {
        if (remarks != null && !remarks.trim().isEmpty()) {
            element.addJavaDocLine("/**");
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine: remarkLines) {
                element.addJavaDocLine(" * " + remarkLine);
            }
            element.addJavaDocLine(" */");
        }
    }

//    @Override
//    public void addConfigurationProperties(Properties properties) {
//
//    }
//
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        addRemark(field, remarks);
    }
//
//    @Override
//    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
//
//    }
//
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String remarks = introspectedTable.getRemarks();
        addRemark(topLevelClass, remarks);
    }
//
//    @Override
//    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
//
//    }
//
//    @Override
//    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
//
//    }
//
//    @Override
//    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
//
//    }
//
//    @Override
//    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
//
//    }
//
//    @Override
//    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
//
//    }
//
//    @Override
//    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
//
//    }
//
//    @Override
//    public void addJavaFileComment(CompilationUnit compilationUnit) {
//
//    }
//
//    @Override
//    public void addComment(XmlElement xmlElement) {
//
//    }
//
//    @Override
//    public void addRootComment(XmlElement rootElement) {
//
//    }
//
//    @Override
//    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
//
//    }
//
//    @Override
//    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
//
//    }
//
//    @Override
//    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
//
//    }
//
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        String remarks = introspectedColumn.getRemarks();
        addRemark(field, remarks);
    }
//
//    @Override
//    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
//
//    }
}
