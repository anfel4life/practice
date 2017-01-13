package com.company;

import java.util.ArrayList;


class SortArray {
    String sortArray(ArrayList<Integer> sortedList) {
        if (sortedList != null && !sortedList.isEmpty()) {
            Integer bigger;
            int size = sortedList.size();
            for (int i = 0; i < size; i++) {
                for (int j = size - 1; j > i; j--) {
                    if (sortedList.get(j) < sortedList.get(j - 1)) {
                        bigger = sortedList.get(j - 1);
                        sortedList.set((j - 1), sortedList.get(j));
                        sortedList.set(j, bigger);
                    }
                }
            }
        }
        return sortedArrayToStr(sortedList);
    }

    private String sortedArrayToStr(ArrayList<Integer> list) {
        StringBuilder s = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                s.append(list.get(i));
                if (i < list.size() - 1) {
                    s.append(",");
                }
            }
        }
        return s.toString();
    }
}
