package com.epam.mentoring.module12;

import com.epam.mentoring.module12.entity.Cab;
import com.epam.mentoring.module12.entity.Company;
import com.epam.mentoring.module12.entity.Driver;
import com.epam.mentoring.module12.entity.Shift;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        Session session = null;

        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            Cab cabExample = session.get(Cab.class, 2);

            System.out.println(cabExample.getCarMake());

            Query cabsQuery = session.createQuery("FROM Cab");
            List<Cab> cabs = cabsQuery.list();
            cabs.stream().map(p -> p.getCarMake()).forEach(System.out::println);

            Query driversQuery = session.createQuery("FROM Driver");
            List<Driver> drivers = driversQuery.list();
            drivers.stream().map(p -> p.getFirstName()).forEach(System.out::println);

            for (Driver curDriver : drivers) {
                System.out.println(curDriver.getFirstName());
                System.out.println(curDriver.getShifts().size());
            }

            Query companiesQuery = session.createQuery("FROM Company");
            List<Company> companies = companiesQuery.list();
            companies.stream().map(p -> p.getName()).forEach(System.out::println);

            Query shiftsQuery = session.createQuery("FROM Shift");
            List<Shift> shifts = shiftsQuery.list();
            shifts.stream().map(p -> p.getDriverId()).forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("An exception appeared.");
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            session.close();
        }

        // Id generation:
        // - Auto (default). @GeneratedValue(strategy = GenerationType.AUTO). Better for performance
        // - Identity (for a particular Entity class). @GeneratedValue(strategy = GenerationType.IDENTITY)
        // - Sequence.
        //      @SequenceGenerator before class,
        //      @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "<reference to SequenceGenerator annotation>")
        // - Table.
        //      @TableGenerator before class,
        //      @GeneratedValue(strategy = GenerationType.TABLE, generator = "<reference to TableGenerator annotation>")
    }
}
