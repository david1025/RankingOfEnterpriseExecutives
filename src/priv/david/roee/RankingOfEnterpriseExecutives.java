package priv.david.roee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 根据职位排序
 * @author david
 */
public class RankingOfEnterpriseExecutives {

    private static final int OTHER_POSITION_INDEX = 5;
    private static final String OTHER_POSITION_TITLE = "other";

    private static Map<String, Integer> positionMap = new HashMap<>();

    static {
        positionMap.put("董事长", 1);
        positionMap.put("副董事长", 2);
        positionMap.put("执行董事", 3);
        positionMap.put("监事", 4);
        positionMap.put(OTHER_POSITION_TITLE, OTHER_POSITION_INDEX);
        positionMap.put("", 6);
    }

    /**
     * 测试类
     * @param args
     */
    public static void main(String[] args) {
        RankingOfEnterpriseExecutives rankingOfEnterpriseExecutives = new RankingOfEnterpriseExecutives();
        // 正常情况
        List<Person> personList = testData1();
        rankingOfEnterpriseExecutives.sort(personList);
        // 存在职位为空的和没有职位的
        personList = testData2();
        rankingOfEnterpriseExecutives.sort(personList);

        // 为空的情况
        rankingOfEnterpriseExecutives.sort(null);

        // 空list情况
        rankingOfEnterpriseExecutives.sort(new ArrayList<>());
        System.out.println(personList);
    }

    public static List<Person> testData1() {
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

        return personList;
    }

    public static List<Person> testData2() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("刘华");
        person.setPosition("监事,总经理");
        personList.add(person);

        person = new Person();
        person.setName("卢山");
        person.setPosition("副总监");
        personList.add(person);

        person = new Person();
        person.setName("马化腾");
        person.setPosition("总经理,董事长");
        personList.add(person);

        person = new Person();
        person.setName("奚丹");
        person.setPosition("副董事长");
        personList.add(person);

        person = new Person();
        person.setName("没有职位");
        personList.add(person);

        return personList;
    }

    /**
     * 根据职位排序
     * @param personList 人员列表
     */
    public void sort(List<Person> personList) {
        if (personList == null) {
            return;
        }
        Map<Integer, Person> personTreeMap = new TreeMap<>();
        for (Person person : personList) {
            String highestPosition = getHighestPosition(person.getPosition());
            personTreeMap.put(positionMap.get(highestPosition), person);
        }
        personList.clear();
        for(Map.Entry<Integer, Person> entry :personTreeMap.entrySet()) {
            personList.add(entry.getValue());
        }

    }

    /**
     * 获取最高的职位
     * @param position 职位，多职位逗号分割
     * @return 最高的职位，没有返回空“”
     */
    private String getHighestPosition(String position) {
        if (position == null) {
            position = "";
        }
        Map<Integer, String> positionTreeMap = new TreeMap<>();
        String[] positionArr = position.split(",");
        for (String pos: positionArr) {
            if (positionMap.get(pos) == null) {
                positionTreeMap.put(OTHER_POSITION_INDEX , OTHER_POSITION_TITLE);
            } else {
                positionTreeMap.put(positionMap.get(pos) , pos);
            }

        }
        return positionTreeMap.entrySet().iterator().next().getValue();
    }

}
