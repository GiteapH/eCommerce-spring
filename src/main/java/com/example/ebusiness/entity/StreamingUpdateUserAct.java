package com.example.ebusiness.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import java.math.BigDecimal;
    import java.time.LocalDate;
    import java.time.LocalTime;
import io.swagger.annotations.ApiModel;
    import lombok.Getter;
    import lombok.Setter;

/**
* <p>
    * 
    * </p>
*
* @author 程序员小于
* @since 2023-08-04
*/
    @Getter
    @Setter
    @TableName("streaming_update_user_act")
@ApiModel(value = "StreamingUpdateUserAct对象", description = "")
    public class StreamingUpdateUserAct implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate actDate;

    private LocalTime actTime;

    private Long user;

    private Integer actType;

    private Long sku;

    private BigDecimal price;

    private String province;

    private String city;

    private String county;

    private String gender;

    private Integer age;
}