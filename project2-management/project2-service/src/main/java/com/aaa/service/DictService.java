package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.DictMapper;
import com.aaa.model.Dict;
import com.aaa.utils.BaseUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

import static com.aaa.status.OperationStatus.FAILED;
import static com.aaa.status.OperationStatus.SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_FAILED;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @ClassName DictService
 * @Description TODO
 * @Author jyz
 * @date 2020/7/17 19:00
 **/
@Service
public class DictService extends BaseService<Dict> {
    @Autowired
    private DictMapper dictMapper;

    /**
     * @Author jyz
     * @Description //TODO 分页查询字典信息
     * @Date 19:16 2020/7/17
     * @Param [hashMap]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    public HashMap<String , Object> selectAllDictByPage(HashMap hashMap) throws Exception{
        HashMap<String , Object> resultMap = new HashMap<String, Object>();
        Dict dict = new Dict();
        PageInfo<Dict> dictPageInfo = super.selectListByPage(dict, BaseUtils.transToInt(hashMap.get("pageNo")), BaseUtils.transToInt(hashMap.get("pageSize")));
        if (null != dictPageInfo && dictPageInfo.getSize()>0){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",dictPageInfo);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author jyz
     * @Description //TODO 通过id批量删除字典
     * @Date 19:28 2020/7/17
     * @Param [ids]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    public HashMap<String,Object> delDictsById(List<Long> ids){
        HashMap<String,Object> resultMap = new HashMap<String, Object>();
        Example example = Example.builder(Dict.class).where(Sqls.custom().andIn("id",ids)).build();
        int i = dictMapper.deleteByExample(example);
        if (i > 0){
            resultMap.put("code",SUCCESS.getCode());
            resultMap.put("msg",SUCCESS.getMsg());
        }else {
            resultMap.put("code",FAILED.getCode());
            resultMap.put("msg",FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author jyz
     * @Description //TODO 修改字典信息
     * @Date 19:34 2020/7/17
     * @Param [dict]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    public HashMap<String,Object> updateDict(Dict dict){
        HashMap<String,Object> resultMap = new HashMap<String, Object>();
        if (null != dict || !"".equals(dict)){
            int dictUpdateResult = dictMapper.updateByPrimaryKey(dict);
            if (dictUpdateResult > 0){
                resultMap.put("code",SUCCESS.getCode());
                resultMap.put("msg", SUCCESS.getMsg());
            }else {
                resultMap.put("code",FAILED.getCode());
                resultMap.put("msg",FAILED.getMsg());
            }
        }else {
            resultMap.put("code","50001");
            resultMap.put("msg","数据为空");
        }
        return resultMap;
    }

    /**
     * @Author jyz
     * @Description //TODO 新增字典信息
     * @Date 19:35 2020/7/17
     * @Param [dict]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    public HashMap<String,Object> addDict(Dict dict){
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        int addDictResult = dictMapper.insertSelective(dict);
        if (addDictResult > 0){
            resultMap.put("code", SUCCESS.getCode());
            resultMap.put("msg", SUCCESS.getMsg());
        }else{
            resultMap.put("code", FAILED.getCode());
            resultMap.put("msg", FAILED.getMsg());
        }
        return resultMap;
    }
}
