package com.example.ebusiness.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;

import io.swagger.annotations.ApiModel;

    import lombok.Getter;
    import lombok.Setter;

/**
* <p>
    * 
    * </p>
*
* @author 程序员小于
* @since 2023-08-12
*/
    @Getter
    @Setter
    @TableName("change_calculate")
@ApiModel(value = "ChangeCalculate对象", description = "")
    public class ChangeCalculate implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String beforeTag;

    private String afterTag;

    private Double consumptionCapacityScoreDiff;

    private Double frequencyScoreDiff;

    private Double recencyScoreDiff;
}