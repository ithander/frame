<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePkg}.${beanName}.mapper.${BeanName}Mapper">


    <!-- 新增${BeanName} -->
    <insert id="add" parameterType="${basePkg}.${beanName}.bean.${BeanName}" useGeneratedKeys="true" keyProperty="${priKey!"id"}">
    	INSERT INTO `${tableName}` (
			<#list fields as fd>
			    <#if fd_index!=0 >,</#if>
			    `${fd.column_name}`
			</#list>
		)
		VALUES
			(
			   <#list fields as fd>
			       <#if fd_index!=0 >,</#if>
			         <#noparse>#{</#noparse>${fd.column_name}<#noparse>}</#noparse>
			   </#list>
			)
    </insert>

    <!-- 根据ID得到指定记录 -->
    <select id="get" resultType="${basePkg}.${beanName}.bean.${BeanName}">
        select t.* from `${tableName}` t where `t.${priKeyColumn!"id"}`=<#noparse>#{</#noparse>${priKey!"id"}<#noparse>}</#noparse>
    </select>
    
    <delete id="delete">
        delete from `${tableName}` where `${priKeyColumn!"id"}`=<#noparse>#{</#noparse>${priKey!"id"}<#noparse>}</#noparse>
    </delete>
    
    <delete id="batchDelete">
        delete from `${tableName}` where `${priKeyColumn!"id"}` in
        <foreach collection="_parameter.containsKey('ids')" open="(" separator="," close=")" item="id">
            <#noparse>#{</#noparse>id<#noparse>}</#noparse>
        </foreach>
    </delete>
    
    <update id="update">
        update `${tableName}`
        <set>
            <trim prefix="" prefixOverrides="," suffixOverrides=",">
                <#list fields as fd>
                    <#if fd.column_key!='pri' && fd.column_key!='PRI'>
	                    <if test="${fd.column_name}!=null">
	                        `${fd.column_name}`=<#noparse>#{</#noparse>${fd.column_name}<#noparse>}</#noparse> ,
	                    </if>
                    </#if>
			    </#list>
            </trim>
        </set>
        where `${priKeyColumn!"id"}`=<#noparse>#{</#noparse>${priKey!"id"}<#noparse>}</#noparse>
    </update>
    
    
    <!-- 查询所有数据 -->
    <select id="list" resultType="${basePkg}.${beanName}.bean.${BeanName}">
        select t.* from `${tableName}` t
        <trim prefix="where" prefixOverrides="and|or" suffixOverrides="and|or">
            <if test="_parameter.containsKey('ids')">
                <foreach collection="ids" index="index" item="id">
                    t.`${priKeyColumn!"id"}`=<#noparse>#{</#noparse>${priKey!"id"}<#noparse>}</#noparse> or
                </foreach>
            </if>
        </trim>
    </select>
    
    <!-- 分页查询部分数据 -->
    <select id="page" resultType="${basePkg}.${beanName}.bean.${BeanName}">
        select t.* from `${tableName}` t
        <trim prefix="where" prefixOverrides="and|or" suffixOverrides="and|or">
            <#list fields as fd>
                <if test="page.bean.${fd.column_name}!=null">
                    t.`${fd.column_name}`=<#noparse>#{</#noparse>page.bean.${fd.column_name}<#noparse>}</#noparse> and
                </if>
			</#list>
        </trim>
    </select>
    
    <!-- 分页查询部分数据 -->
    <select id="query" resultType="${basePkg}.${beanName}.bean.${BeanName}">
        select t.* from `${tableName}` t
        <trim prefix="where" prefixOverrides="and|or" suffixOverrides="and|or">
            <#list fields as fd>
                <if test="${fd.column_name}!=null">
                    t.`${fd.column_name}`=<#noparse>#{</#noparse>${fd.column_name}<#noparse>}</#noparse> and
                </if>
			</#list>
        </trim>
    </select>

</mapper>