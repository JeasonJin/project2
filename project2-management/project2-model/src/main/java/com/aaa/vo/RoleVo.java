package com.aaa.vo;

import com.aaa.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author jyz
 * @Description //TODO
 * @Date 9:40 2020/7/18
 * @Param
 * @return
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleVo implements Serializable {

    private List<Long> menuId;

    private Role role;

    private Integer pageNo;

    private Integer pageSize;
}
