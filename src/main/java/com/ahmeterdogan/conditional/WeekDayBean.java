package com.ahmeterdogan.conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component("week")
@Conditional(WeekDayControl.class)
public class WeekDayBean {
}

@Component("weekend")
@Conditional(WeekendDayControl.class)
class WeekendDayBean {

}

class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("conditionalBeans.xml");
        System.out.println(applicationContext.containsBean("week"));
        System.out.println(applicationContext.containsBean("weekend"));

    }
}

class WeekDayControl implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return !Util.isTodayWeekend();
    }
}

class WeekendDayControl implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Util.isTodayWeekend();
    }
}

class Util {
    public static boolean isTodayWeekend() {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        boolean result = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY ,FRIDAY  -> false;
            case SATURDAY, SUNDAY -> true;
        };

        return result;
    }
}
