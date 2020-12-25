package com.ynhuang.thinking.myXmlTag;

import com.ynhuang.thinking.bean.UserInfo;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author YuHuang
 */
public class UserInfoNameSpace extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("userinfo", new UserInfoBeanDefinitionParser());
    }

    class UserInfoBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {

        @Override
        protected Class<?> getBeanClass(Element element) {
            return UserInfo.class;
        }

        @Override
        protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
            String id = element.getAttribute("id");
            String name = element.getAttribute("name");
            String age = element.getAttribute("age");

            builder.addPropertyValue("id", id);
            builder.addPropertyValue("name", name);
            builder.addPropertyValue("age", age);
        }
    }
}
