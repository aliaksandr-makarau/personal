package com.epam.mentoring.module05.factorydemo.factory;

import com.epam.mentoring.module05.factorydemo.model.Human;
import com.epam.mentoring.module05.factorydemo.model.SuperHero;

import java.util.HashMap;
import java.util.Map;

public class BioReactor {

    private interface HumanCreator {
        Human getHuman();
    }

    private static Map<String, HumanCreator> humanTypesCreators = new HashMap<>();
    static {
        humanTypesCreators.put("SuperHero", () -> new SuperHero() );
    }

    public static Human getHuman(String type) {
        HumanCreator creator = humanTypesCreators.get(type);
        return creator.getHuman();
    }
}
