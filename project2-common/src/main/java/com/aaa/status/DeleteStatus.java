package com.aaa.status;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/17 9:48
 * @Description:
 *       删除操作的状态码
 */
public enum DeleteStatus {
    DELETE_DATA_SUCCESS("22001", "删除数据成功"),
    DELETE_DATA_FAILED("12001", "删除数据失败"),
    DELETE_DATA_NOT_EXIST("12002","数据不存在，删除失败！"),
    DELETE_DATA_ERROR("12003","出现未知错误，请稍后再试！"),

    TEST("11111", "测试一下");


    DeleteStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
