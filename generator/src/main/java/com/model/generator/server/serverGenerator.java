package com.model.generator.server;

import com.model.generator.util.DbUtil;
import com.model.generator.util.Field;
import com.model.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class serverGenerator {
    static String MODULE = "business"; //可以生成多个不同模块的代码
    static String toServicePath = "server\\src\\main\\java\\com\\model\\server\\service\\";
    static String toDtoPath = "server\\src\\main\\java\\com\\model\\server\\dto\\";
    static String toControllerPath = "business\\src\\main\\java\\com\\model\\business\\controller\\admin\\";
    static String generatorConfigPath = "server\\src\\main\\resources\\generator\\generatorConfig.xml";


    public static void main(String[] args) throws Exception {
        String Domain = "Component";
        String domain = "component";
        String tableNameCn = "组件";

//        // 只生成配置文件中的第一个table节点
//        File file = new File(generatorConfigPath);
//        SAXReader reader=new SAXReader();
//        //读取xml文件到Document中
//        Document doc=reader.read(file);
//        //获取xml文件的根节点
//        Element rootElement=doc.getRootElement();
//        //读取context节点
//        Element contextElement = rootElement.element("context");
//        //定义一个Element用于遍历
//        Element tableElement;
//        //取第一个“table”的节点
//        tableElement=contextElement.elementIterator("table").next();
//        String Domain = tableElement.attributeValue("domainObjectName");
//        String tableName = tableElement.attributeValue("tableName");
//        String tableNameCn = DbUtil.getTableComment(tableName);
//        String domain = Domain.substring(0, 1).toLowerCase() + Domain.substring(1);
//        System.out.println("表："+tableElement.attributeValue("tableName"));
//        System.out.println("Domain："+tableElement.attributeValue("domainObjectName"));

        List<Field> fieldList = DbUtil.getColumnByTableName(domain);
        Set<String> typeSet = getJavaTypes(fieldList);
        Map<String,Object> map = new HashMap<>();
        map.put("Domain",Domain);
        map.put("domain",domain);
        map.put("tableNameCn",tableNameCn);
        map.put("fieldList", fieldList);
        map.put("typeSet", typeSet);

        //生成Dto
        FreemarkerUtil.initConfig("dto.ftl");
        FreemarkerUtil.generator(toDtoPath+Domain+"Dto.java",map);
        //生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath+Domain+"Service.java",map);

        //生成Controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath+Domain+"Controller.java",map);



    }

    /**
     * 获取所有的Java类型，并去重
     * @param fieldList
     * @return
     */
    private static Set<String> getJavaTypes(List<Field> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            set.add(field.getJavaType());
        }
        return set;
    }
}

