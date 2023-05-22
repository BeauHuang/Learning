package com.hb.learn.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Game
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/9 19:05
 * @Version 1.0
 */
public class Game {
    public static void main(String[] args) {
        // 测试数据
        int player_count = 3;
        int[] int_values = {2, 3, 5, 4, 1, 6, 8, 7};
        //int[] int_values = {2, 3, 5, 4, 1, 6};
        // 计算获胜玩家ID
        int winner = game(player_count, int_values);
        // 输出结果
        System.out.println("Winner is " + winner);
    }

    /**
     * 假如，有3 个玩家，游戏序列为 [2, 3, 5, 4, 1, 6]。
     * 游戏过程如下：
     * - 玩家0：移除6
     * - 玩家1：移除5，4，1
     * - 玩家2：移除3
     * - 玩家0：移除2
     * 结果：玩家0 获胜。
     *
     * @param playerCount
     * @param intValues
     * @return
     */
    private static int game(int playerCount, int[] intValues) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < intValues.length; i++) {
            list.add(intValues[i]);
        }

        int count = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            int max = getMaxFromList(list);
            while (list.get(i) != max) {
                list.remove(i);
                i--;
            }
            list.remove(i);
            count++;
        }

        return count % playerCount;
    }

    private static Integer getMaxFromList(List<Integer> list) {

        List<Integer> tmpList = new ArrayList<>();
        tmpList.addAll(list);

        Collections.sort(tmpList);

        return tmpList.get(tmpList.size() - 1);
    }
}
