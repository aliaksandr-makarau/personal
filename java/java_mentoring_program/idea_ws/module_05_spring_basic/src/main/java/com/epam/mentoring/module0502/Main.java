package com.epam.mentoring.module0502;

import com.epam.mentoring.module0502.beans.AutomationTester;
import com.epam.mentoring.module0502.beans.Developer;
import com.epam.mentoring.module0502.beans.Manager;
import com.epam.mentoring.module0502.beans.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans02.xml");
        Developer dev = context.getBean("dev", Developer.class);
        System.out.println(dev);
        AutomationTester tester = context.getBean("tester", AutomationTester.class);
        System.out.println(tester);
        Manager manager = context.getBean("manager", Manager.class);
        System.out.println(manager);

        // Bean Lifecycle:
        // 1. Instantiate a bean
        // 2. Populate properties for a bean
        // 3. BeanNameAware's setBeanName()
        // 4. BeanFactoryAware's setBeanFactory()
        // 5. ApplicationContextAware's setApplicationContext()
        // 6. Pre-initialization BeanPostProcessors
        // 7. InitializingBean's afterPropertiesSet()
        // 8. Call custom init-method
        // 9. Post-initialization BeanPostProcessors
        // ------------------------
        // Using of the bean
        // ------------------------
        // 10. DisposableBean's destroy()
        // 11. Call custom destroy method

        // How to close a context?
        // .close() (not always executed when java process is killed)
        // .registerShutdownHook()

        // Init method for a bean must be without parameters and return void

        Project nyTimes = context.getBean("project_NYTimes", Project.class);
        System.out.println(nyTimes);

        // No guarantee that afterPropertiesSet() will be called before or after init methods
        // or even constructors of beans. Hence, It is not a good idea using afterPropertiesSet().

        // To call a destroy method a context should be closed
        // ((AbstractApplicationContext)context).close();

        Developer cppDev = context.getBean("devFromParent", Developer.class);
        System.out.println(cppDev);
        AutomationTester cppTester = context.getBean("testerFromParent", AutomationTester.class);
        System.out.println(cppTester);
        Manager cppManager = context.getBean("managerFromParent", Manager.class);
        System.out.println(cppManager);
    }
}
