package com.datafly.generator.business.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 */
@Data
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收件人电话
     */
    private String consigneeTel;

    /**
     * 总金额
     */
    private BigDecimal finalTotalAmount;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 用户id
     */
    private Long userId;


    /**
     * 送货地址
     */
    private String deliveryAddress;

    /**
     * 订单备注
     */
    private String orderComment;

    /**
     * 订单交易编号（第三方支付用)
     */
    private String outTradeNo;

    /**
     * 订单描述(第三方支付用)
     */
    private String tradeBody;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 失效时间
     */
    private Date expireTime;

    /**
     * 物流单编号
     */
    private String trackingNo;

    /**
     * 父订单编号
     */
    private Long parentOrderId;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 地区
     */
    private Integer provinceId;


    private BigDecimal originalTotalAmount;

    private BigDecimal feightFee;

    private BigDecimal benefitReduceAmount;


    @TableField(exist = false)
    private List<OrderDetail> orderDetailList;

    public void sumTotalAmount() {

        this.benefitReduceAmount = this.benefitReduceAmount == null ? BigDecimal.ZERO : this.benefitReduceAmount;
        this.feightFee = this.feightFee == null ? BigDecimal.ZERO : this.feightFee;
        this.originalTotalAmount = this.originalTotalAmount == null ? BigDecimal.ZERO : this.originalTotalAmount;
        this.finalTotalAmount = this.finalTotalAmount == null ? BigDecimal.ZERO : this.finalTotalAmount;


        BigDecimal totalAmount = new BigDecimal("0");
        for (OrderDetail orderDetail : orderDetailList) {
            totalAmount = totalAmount.add(orderDetail.getOrderPrice().multiply(new BigDecimal(orderDetail.getSkuNum())));
        }
        this.originalTotalAmount = totalAmount;

        this.finalTotalAmount = originalTotalAmount.subtract(benefitReduceAmount).add(feightFee);

    }

    //生成摘要
    public String getOrderSubject() {
        String body = "";
        if (orderDetailList != null && orderDetailList.size() > 0) {
            body = orderDetailList.get(0).getSkuName();
        }
        body += "等" + getTotalSkuNum() + "件商品";
        return body;

    }

    public Long getTotalSkuNum() {
        Long totalNum = 0L;
        for (OrderDetail orderDetail : orderDetailList) {
            totalNum += orderDetail.getSkuNum();
        }
        return totalNum;
    }
}
