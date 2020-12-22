package priv.david.roee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RankingOfEnterpriseExecutivesTests {



    @Test
    public void testSort_NoData() {
        RankingOfEnterpriseExecutives rankingOfEnterpriseExecutives = new RankingOfEnterpriseExecutives();
        rankingOfEnterpriseExecutives.sort(null);
    }

    @Test
    public void testSort_AllPositionCanFind() {
        RankingOfEnterpriseExecutives rankingOfEnterpriseExecutives = new RankingOfEnterpriseExecutives();

        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("刘华");
        person.setPosition("监事");
        personList.add(person);

        person = new Person();
        person.setName("卢山");
        person.setPosition("董事");
        personList.add(person);

        person = new Person();
        person.setName("马化腾");
        person.setPosition("总经理,董事长");
        personList.add(person);

        person = new Person();
        person.setName("奚丹");
        person.setPosition("副董事长");
        personList.add(person);
        rankingOfEnterpriseExecutives.sort(personList);
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testSort_PartPositionCanFindAndPartPositionCanNotFind() {
        RankingOfEnterpriseExecutives rankingOfEnterpriseExecutives = new RankingOfEnterpriseExecutives();

        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("刘华");
        person.setPosition("监事");
        personList.add(person);

        person = new Person();
        person.setName("卢山");
        person.setPosition("董事");
        personList.add(person);

        person = new Person();
        person.setName("马化腾");
        person.setPosition("总经理,董事长");
        personList.add(person);

        person = new Person();
        person.setName("奚丹");
        person.setPosition("总监");
        personList.add(person);

        person = new Person();
        person.setName("张三");
        person.setPosition("");
        personList.add(person);
        rankingOfEnterpriseExecutives.sort(personList);
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testSort_AllPositionCanNotFind() {
        RankingOfEnterpriseExecutives rankingOfEnterpriseExecutives = new RankingOfEnterpriseExecutives();

        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("刘华");
        person.setPosition("总经理，总监");
        personList.add(person);

        person = new Person();
        person.setName("卢山");
        person.setPosition("副总经理");
        personList.add(person);

        person = new Person();
        person.setName("张三");
        person.setPosition("普通员工");
        personList.add(person);

        person = new Person();
        person.setName("李四");
        person.setPosition("");
        personList.add(person);

        rankingOfEnterpriseExecutives.sort(personList);
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testSort_HasNullData() {
        RankingOfEnterpriseExecutives rankingOfEnterpriseExecutives = new RankingOfEnterpriseExecutives();

        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("刘华");
        person.setPosition("监事");
        personList.add(person);

        personList.add(null);
        rankingOfEnterpriseExecutives.sort(personList);
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }
}
