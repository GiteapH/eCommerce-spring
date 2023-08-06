package com.example.ebusiness.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
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
* @since 2023-07-04
*/
    @Getter
    @Setter
    @TableName("sku_jump_loss")
@ApiModel(value = "SkuJumpLoss对象", description = "")
    public class SkuJumpLoss implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sku;

            // 0 = sku同一浏览用户只浏览一次 1 = 同一浏览用户浏览次数大于一次
            @ApiModelProperty("0 = sku同一浏览用户只浏览一次 1 = 同一浏览用户浏览次数大于一次")
            @Alias("0 = sku同一浏览用户只浏览一次 1 = 同一浏览用户浏览次数大于一次")
    private Integer watch;

    private Integer watchNum;
}