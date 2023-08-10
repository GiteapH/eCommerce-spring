package com.example.ebusiness.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.time.LocalDate;
import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
    import lombok.Getter;
    import lombok.Setter;

/**
* <p>
    * 
    * </p>
*
* @author 程序员小于
* @since 2023-07-31
*/
    @Getter
    @Setter
    @TableName("user_daily_act")
@ApiModel(value = "UserDailyAct对象", description = "")
    public class UserDailyAct implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private LocalDate date;

    private Integer view;

    private Integer cart;

    private Integer fan;

    private Integer buy;

    private Integer complain;

    private Integer comment;

    private Integer consult;

            // 购买额
            @ApiModelProperty("购买额")
            @Alias("购买额")
    private Double buyLine;

            // 间隔
            @ApiModelProperty("间隔")
            @Alias("间隔")
    private Integer interval;


            private String rfm;
}