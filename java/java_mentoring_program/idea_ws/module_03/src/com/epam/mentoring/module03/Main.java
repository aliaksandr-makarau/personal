package com.epam.mentoring.module03;

import com.epam.mentoring.module03.entities.Department;
import com.epam.mentoring.module03.entities.Employee;
import com.epam.mentoring.module03.model.BusinessTask;
import com.epam.mentoring.module03.model.BusinessTaskUpdateCustomerAgeOnThread;
import com.epam.mentoring.module03.tasks.BusinessTaskUpdateCustomerAge;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private interface SimpleInterface {
        int calculate(int a, int b);
    }

    private interface Factory<T> {
        T make();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Java Mentoring Program - Module 3");

        // 1. Single Abstract Method Interface
        // Interface with one method
        // For example, Runnable
        // Annotation @FunctionalInterface

        SimpleInterface functionalInterfaceObjectExample = (a, b) -> {
            System.out.println("First argument: " + a);
            System.out.println("Second argument: " + b);
            return a + b;
        };

        System.out.println(functionalInterfaceObjectExample.calculate(2, 3));
        System.out.println(functionalInterfaceObjectExample.calculate(5, 8));

        // 2. Method Reference

        Factory<List<String>> stringListFactory = ArrayList::new;
        Collection<String> stringCollectionExample = stringListFactory.make();
        stringCollectionExample.add("String Example #1");

        System.out.println(stringCollectionExample.size());

        // 3. First coding session

        // The first option
        BusinessTaskUpdateCustomerAgeOnThread exampleTaskFirst = new BusinessTaskUpdateCustomerAgeOnThread();
        BusinessTaskUpdateCustomerAgeOnThread exampleTaskSecond = new BusinessTaskUpdateCustomerAgeOnThread();

        exampleTaskFirst.start();
        exampleTaskSecond.start();

        // The second option
        Runnable exampleTaskThird  = () -> {
            try {
                new BusinessTaskUpdateCustomerAge().updateStateInDB();
                Thread.sleep(10000);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        };

        executeTask(exampleTaskThird);
        executeTask(exampleTaskThird);

        // The third option
        executeTask(() -> {
            try {
                new BusinessTaskUpdateCustomerAge().updateStateInDB();
                Thread.sleep(10000);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });

        // The fourth option
        ((BusinessTask) () -> {}).updateStateInMemory();

        // 4. Second coding session
        double pi = 3.14;

        Runnable calculatePi = () -> {
            double rectification = 0.0015;
            // pi += 0.0015 // Compilation error
            // Outer variables CANNOT be changed in lambda
            System.out.println("Result: " + (pi + rectification));
        };

        new Thread(calculatePi).start();

        // pi += 0.0015; // Compilation error
        // Variable used in lambda should be final or effectively final

        // the second option

        // HACK
        final double[] piArray = { 3.14 };

        Runnable calculatePiAlternative = () -> {
            piArray[0] += 0.0015;
            System.out.println("Result: " + (piArray[0]));
        };

        Thread calculatePiThread = new Thread(calculatePiAlternative);
        calculatePiThread.start();
        calculatePiThread.join();

        System.out.println("piArray: " + piArray[0]);

        // 5. Functional interface
        // Lambda expression is a functional interface
        // Functional interfaces:
        // Runnable
        // Supplier<T>
        // Consumer<T>
        // Function<T, R>
        // BiFunction<T, R, U>
        // UnaryOperator<T>
        // Predicate<T>

        // 6. Streams
        // source ->
        // .operation
        // .operation
        // .operation
        // -> sink

        // Stream is NOT a Collection

        List<String> countries = Arrays.asList( "USa", "   RUSsia    ", "gerMany", "JapaN" );

        System.out.println("Option 5.1:");
        countries.forEach(System.out::println);

        System.out.println("Option 5.2:");
        countries.stream().forEach((String country) -> {
            System.out.println(country);
        });

        System.out.println("Option 5.3:");
        for (int i = 0; i < countries.size(); ++i) {
            String newItem = countries.get(i).toLowerCase().trim();
            if (newItem.contains("j")) {
                continue;
            }
            System.out.println(newItem);
        }

        System.out.println("Option 5.4:");
        countries.stream()
                .map(e -> e.toLowerCase().trim())
                .filter(p -> !p.contains("j"))
                .forEach(System.out::println);

        System.out.println("Option 5.5:");
        Stream<Integer> numbers = Arrays.asList(1, 4, 3, 5, 6, 8).stream();

        numbers.filter(p -> (p > 4))
                .map(e -> e + 10)
                .map(z -> { System.out.println(0); return 10; })
                .forEach(System.out::println);

        // numbers.forEach(System.out::println); // IllegalStateException
        // see stream intermediate and terminal operations

        System.out.println("Option 5.6:");
        IntStream.iterate(0, i -> i + 11)
                .limit(100)
                .forEach(System.out::println);

        System.out.println("Option 5.7:");
        Arrays.asList(1.0, 45.0, 67.0, 33.0, 12.0, 9.99)
                .stream()
                .sorted()
                .forEach(System.out::println);

        // Intermediate Stream operations:
        // filter
        // map
        // flatMap
        // peek
        // sorted
        // distinct
        // skip
        // limit
        // unordered
        // sequential
        // PARALLEL

        // Terminal Stream operations:
        // iteration
        // searching
        // matching
        // aggregation: reduction, collectors

        // 7. Aggregation
        // Java 7 -> Java 8

        System.out.println("Option 7.1: ");
        List<Employee> employees = hireFourEmployee();
        List<Department> departments = new ArrayList<>();

        for (Employee curEmployee : employees) {
            if (curEmployee.getLevel() > 2) {
                departments.add(curEmployee.getDepartment());
            }
        }

        Set<Department> distinctDepartments = new HashSet<>();

        for (Department curDepartment : departments) {
            distinctDepartments.add(curDepartment);
        }

        ArrayList<Department> resultList = new ArrayList<>(distinctDepartments);

        Collections.sort(resultList, new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {

                if (o1 == o2) {
                    return 0;
                }

                if (o1 == null) {
                    return -1;
                }

                if (o2 == null) {
                    return 1;
                }

                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Department curDepartment : resultList) {
            System.out.println(curDepartment);
        }

        int sum = 0;
        int counter = 0;

        for (Employee curEmployee : employees) {
            sum += curEmployee.getAge();
            counter++;
        }

        System.out.println("Average age is " + (sum / counter));

        System.out.println("Option 7.2: ");
        List<Employee> employeesOnStreams  = hireFourEmployee();

        employeesOnStreams.stream()
                .filter(e -> (e.getLevel() > 2))
                .map(e -> e.getDepartment())
                .distinct()
                .sorted(Comparator.comparing(e -> e.getName()))
                .forEach(e -> System.out.println(e.getName()));

        System.out.println(employeesOnStreams.stream()
                .mapToInt(e -> e.getAge())
                .summaryStatistics());

        // 8. Parallel
        // stream().parallel()
        // parallelStream()
    }

    private static void executeTask(Runnable task) {
        new Thread(task).start();
    }

    private static List<Employee> hireFourEmployee() {

        Department financial = new Department("Financial Department");
        Department mobile = new Department("Mobile Department");

        return Arrays.asList(
                new Employee(18, "Petr", "Java", 1, financial),
                new Employee(25, "Olga", ".Net", 3, financial),
                new Employee(38, "John", "Delphi", 4, mobile),
                new Employee(43, "Sergey", "Java", 4, mobile)
        );
    }
}
