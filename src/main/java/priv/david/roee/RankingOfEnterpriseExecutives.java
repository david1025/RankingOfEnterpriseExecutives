package priv.david.roee;

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
     * 根据职位排序
     * @param personList 人员列表
     */
    public void sort(List<Person> personList) {
        if (personList == null) {
            return;
        }
        Map<Integer, Person> personTreeMap = new TreeMap<>();
        for (Person person : personList) {
            if (person != null) {
                String highestPosition = getHighestPosition(person.getPosition());
                personTreeMap.put(positionMap.get(highestPosition), person);
            }
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
