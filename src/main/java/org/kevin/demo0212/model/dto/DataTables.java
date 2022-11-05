package org.kevin.demo0212.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-18
 */
@Data
@NoArgsConstructor
public class DataTables<T> {
    private int start;
    private int length;
    private int draw;
    private int recordTotals;
    private int recordsFiltered;
    private List<T> data;

    public DataTables(int count, int draw){
        this.recordTotals = count;
        this.recordsFiltered = count;
        this.draw = draw;
    }
}
