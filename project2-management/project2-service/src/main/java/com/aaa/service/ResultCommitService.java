package com.aaa.service;

import com.aaa.mapper.ResultCommitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.SelectStatus.*;

/**
 * Package: com.aaa.service
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/17 21:59
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@Service
public class ResultCommitService {
    @Autowired
    private ResultCommitMapper resultCommitMapper;

    /**
     * @Author yao
     * @Description //查询所有测绘成果
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    public Map<String,Object> selectAllResultCommit(HashMap hashMap) {
        HashMap<String,Object> resultMap = new HashMap<String, Object>();
        List<HashMap> restdata = new ArrayList<HashMap>();
        System.out.println(hashMap.size());
        if (hashMap.size() > 0) {
            restdata = resultCommitMapper.selectResultByFeild(hashMap);
        }else {
            restdata = resultCommitMapper.selectAllResultCommit();
        }
        if (restdata.size()>0) {
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",restdata);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return  resultMap;
    }

      /**
       * @Author yao
       * @Description 查询数据中所有的测绘类型
       * @Date 2020/7/18
       * @Param
       * @return
       **/
      public Map<String,Object>selectMapType(){
          HashMap<String,Object>resultMap = new HashMap<String, Object>();
          List<HashMap> restdata = resultCommitMapper.selectMapType();
          if (restdata.size()>0) {
              resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
              resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
              resultMap.put("data",restdata);
          }else {
              resultMap.put("code",SELECT_DATA_FAILED.getCode());
              resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
          }
          return  resultMap;
      }
      /**
       * @Author yao
       * @Description 查询成果的详细成果
       * @Date 2020/7/18
       * @Param
       * @return
       **/
      public  HashMap<String,Object>resultDetail(String id){
          HashMap<String,Object> resultMap = new HashMap<String, Object>();
          if (null !=id && !("").equals(id)){
              List<HashMap> restdata = resultCommitMapper.resultDetail(id);
              if (restdata.size()==1) {
                  resultMap.put("code",SELECT_DATA_BY_ID_SUCCESS.getCode());
                  resultMap.put("msg",SELECT_DATA_BY_ID_SUCCESS.getMsg());
                  resultMap.put("data",restdata);
                  return  resultMap;
                  }
                }

          resultMap.put("code",SELECT_DATA_BY_ID_FAILED.getCode());
          resultMap.put("msg",SELECT_DATA_BY_ID_FAILED.getMsg());
          return  resultMap;
      }
}
