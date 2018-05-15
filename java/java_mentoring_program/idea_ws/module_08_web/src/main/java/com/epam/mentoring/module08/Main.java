package com.epam.mentoring.module08;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Mentoring Program - Module 08");

        // Java application types:
        // - console
        // - desktop (Swing, JavaFX)
        // - Web
        // - Android
        // - other

        // URL cycle:
        // - URL in browser
        // - Resolver DNS (URL -> IP)
        // - HTTP get by IP
        // - WEB server gets data by HTTP request
        // - HTML response
        // - Browser renders HTTP response

        // Net layers:
        // 1 - Application (HTTP)
        // 2 - Presentation (SSL)
        // 3 - Session
        // 4 - Transport (TCP)
        // 5 - Network (IP)
        // 6 - Data link (IEEE 802.11x)
        // 7 - Physical

        // HTTP
        // - Request string
        // - Header
        // - Body

        // Response codes:
        // 200 OK
        // 401 Unauthorized
        // 404 URL not found
        // 406 Not acceptable
        // 414 Request too long
        // 429 Too many requests

        // HTTP methods
        // GET (select / read)
        // POST (insert / create)
        // HEAD
        // PUT (update)
        // DELETE (delete)
        // OPTIONS / CONNECT

        // Cookies
        // Local storage in HTML 5

        // HTTP 2.0 (multiplexing)

        // Browser functions:
        // HTTP client
        // Renders HTML & CSS
        // Runs JavaScript applications
        // Manages cookies
        // Caching pages

        // Servlets
        // Java Servlet API

        // Web server
        // Application container
        // Servlet

        // Servlet
        // 1. constructor
        // 2. init
        // 3. service
        // 4. destroy

        // MVC
        // Model (Beans, JPA)
        // View (JSP)
        // Controller (servlet)

        // Pure servlets are faster than JSP

        // JSP engine in web container compiles JSP to a servlet
        // MyJSP.jsp -> MyJSP_jsp.java -> MyJSP_jsp.class -> MyJSP_jsp servlet class

        // Class javax.servlet.jsp.JspPage
        // jspInit()
        // _jspService()
        // jspDestroy()

        // JSP Evolution
        // 1. Scriplets:
        //      <%! <some code> %>, <%= <some code> %>
        // 2. EL (expression language)
        //      ${ <some expression> } -> ${param.value}, ${sessionScope.user}
        // 3. JSP custom Tags: declaration <%! %>, expression <%= %>, directive <%@ include file="..." %>, scriptlet and action
        // To include a tag library <%@ taglib prefix="..." uri="..." %>

        // To create a custom tag:
        // - Create a java class inherited from SimpleTagSupport;
    //        public class HelloWorldSimpleTag extends SimpleTagSupport {
    //            @Override
    //            public void doTag() throws JspException, IOException {
    //                getJspContext().getOut().write( "Hello, world!" );
    //            }
    //        }
        // - Create a *.tld file with customization of tag
        //    <tag>
        //        <description>Outputs Hello, World</description>
        //        <name>helloWorld</name>
        //        <tag-class>jsp2.examples.simpletag.HelloWorldSimpleTag</tag-class>
        //        <body-content>empty</body-content>
        //    </tag>
        // - Add to JSP:
        //    <%@ taglib prefix="mytag" uri="/WEB-INF/jsp2/jsp2-example-taglib.tld" %>
        //    ....
        //    <mytag:helloWorld/>

        // 4. JSTL:
        //      - Core (<c: />) <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        //      - SQL
        //      - i18N (internationalization) (<fmt: />)
        //      - XML (<x: />)

        // Java Beans
        // <jsp:useBean id="person" class="ClassBean" scope="request">
        // Scopes:
        //  - page
        //  - request
        //  - session
        //  - application

        // How to test Web application?
        // - Postman
        // - REST-assured
        // - Fiddler

        // Upload tools:
        // Maven
        // Gradle
    }
}
