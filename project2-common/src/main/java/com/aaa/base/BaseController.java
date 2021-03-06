package com.aaa.base;

import static com.aaa.status.AddStatus.*;
import static com.aaa.status.DeleteStatus.*;
import static com.aaa.status.LoginStatus.*;
import static com.aaa.status.OperationStatus.FAILED;
import static com.aaa.status.OperationStatus.SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_FAILED;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;
import static com.aaa.status.UpdateStatus.*;

/**
 * @ClassName BaseController
 * @Description TODO 统一controller
 * @Author jyz
 * @date 2020/7/8 15:29
 **/
public class BaseController {
    /**
     * @Author jyz
     * @Description //TODO 登录成功使用系统消息
     * @Date 16:09 2020/7/8
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Author jyz
     * @Description //TODO 登陆成功自定义返回消息
     * @Date 16:12 2020/7/8
     * @Param [msg]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData loginSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * @Author jyz
     * @Description //TODO 登录成功返回数据信息，使用系统消息
     * @Date 16:14 2020/7/8
     * @Param [data]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author jyz
     * @Description //TODO 登录成功，返回数据信息自定义消息
     * @Date 16:15 2020/7/8
     * @Param [msg, data]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 登录失败，使用系统消息
     * @Date 16:16 2020/7/8
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 登录失败，使用系统消息，详细解释说明
     * @Date 16:16 2020/7/8
     * @Param [detail]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作成功，返回系统消息
     * @Date 16:11 2020/7/9
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作失败，返回系统消息
     * @Date 16:12 2020/7/9
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作成功自定义返回消息
     * @Date 16:52 2020/7/9
     * @Param [msg]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作成功返回数据信息，使用系统消息
     * @Date 16:50 2020/7/9
     * @Param [data]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作成功返回数据信息，自定义消息
     * @Date 16:54 2020/7/9
     * @Param [msg, data]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作失败返回数据信息，使用系统消息
     * @Date 16:56 2020/7/9
     * @Param [data]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationFailed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作失败，自定义返回消息
     * @Date 16:57 2020/7/9
     * @Param [msg]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setData(msg);
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 操作失败，返回数据信息，自定义消息
     * @Date 17:00 2020/7/9
     * @Param [data, msg]
     * @return com.aaa.base.ResultData
     **/
    protected ResultData operationFailed(Object data, String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    protected ResultData loginFailed(Object data, String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

     //查询数据成功

        protected ResultData selectSuccess(Object obj){
            ResultData resultData = new ResultData();
            resultData.setCode(SELECT_DATA_SUCCESS.getCode());
            resultData.setMsg(SELECT_DATA_SUCCESS.getMsg());
            resultData.setData(obj);
            return resultData;
        }
     //查询数据成功，返回自定义消息

    protected ResultData selectSuccess(Object obj, String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(obj);
        return resultData;
    }

        // 查询数据失败


    protected ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_FAILED.getCode());
        resultData.setMsg(SELECT_DATA_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 超时退出
     * @Date 10:29 2020/7/17
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    protected ResultData loginTimeoutExit() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_TIMEOUT_EXIT.getCode());
        resultData.setMsg(LOGIN_TIMEOUT_EXIT.getMsg());
        return resultData;
    }

    /**
     * 添加数据成功，返回系统消息
     */
    protected ResultData addSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_SUCCESS.getCode());
        resultData.setMsg(ADD_DATA_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 添加数据成功，返回自定义消息
     */
    protected ResultData addSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 添加数据失败，返回系统消息
     */
    protected ResultData addFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_FAILED.getCode());
        resultData.setMsg(ADD_DATA_FAILED.getMsg());
        return resultData;
    }

    /**
     *添加数据失败，返回自定义消息
     */
    protected ResultData addFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 添加的数据已经存在，添加失败，返回系统消息
     */
    protected ResultData addDataEexist(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_EXIST.getCode());
        resultData.setMsg(ADD_DATA_EXIST.getMsg());
        return resultData;
    }

    /**
     * 添加的数据已经存在，添加失败，返回自定义消息
     */
    protected ResultData addDataEexist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 修改数据成功
     */
    protected ResultData updateSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_SUCCESS.getCode());
        resultData.setMsg(UPDATE_DATA_SUCCESS.getMsg());
        return resultData;
    }


    /**
     * 修改数据成功，返回自定义消息
     */
    protected ResultData updateSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 修改数据失败
     */
    protected ResultData updateFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_FAILED.getCode());
        resultData.setMsg(UPDATE_DATA_FAILED.getMsg());
        return resultData;
    }


    /**
     *修改数据失败，返回自定义消息
     */
    protected ResultData updateFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


    /**
     * 要修改的数据已存在
     */
    protected ResultData updateDataExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_EXIST.getCode());
        resultData.setMsg(UPDATE_DATA_EXIST.getMsg());
        return resultData;
    }
    /**
     * 删除数据成功，返回系统消息
     */
    protected ResultData deleteSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_DATA_SUCCESS.getCode());
        resultData.setMsg(DELETE_DATA_SUCCESS.getMsg());
        return resultData;
    }


    /**
     * 删除数据成功，返回自定义消息
     */
    protected ResultData deleteSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 删除数据失败
     */
    protected ResultData deleteFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_DATA_FAILED.getCode());
        resultData.setMsg(DELETE_DATA_FAILED.getMsg());
        return resultData;
    }

    /**
     * 删除数据失败，返回自定义数据
     */
    protected ResultData deleteFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_DATA_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


    /**
     * 删除的数据不存在，删除失败
     */
    protected ResultData deleteDataNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_DATA_NOT_EXIST.getCode());
        resultData.setMsg(DELETE_DATA_NOT_EXIST.getMsg());
        return resultData;
    }

    /**
     * 出现未知错误，请稍后再试！
     */
    protected ResultData deleteDataError(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_DATA_ERROR.getCode());
        resultData.setMsg(DELETE_DATA_ERROR.getMsg());
        return resultData;
    }


}
