<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePkg}.${beanName}.mapper.Z${BeanName}Mapper">
 
    <!-- 根据ID得到指定记录 -->
    <select id="get" resultType="${basePkg}.${beanName}.bean.${BeanName}">
        ${gsql} where t.`${priKeyColumn!"id"}`=<#noparse>#{</#noparse>${priKey!"id"}<#noparse>}</#noparse>
    </select>
 
    <!-- 查询所有数据 -->
    <select id="list" resultType="${basePkg}.${beanName}.bean.${BeanName}">
        ${gsql}
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
        ${gsql}
        <trim prefix="where" prefixOverrides="and|or" suffixOverrides="and|or">
            <#list fields as fd>
                <if test="page.bean.${fd.column_name}!=null">
                    t.`${fd.column_name}`=<#noparse>#{</#noparse>page.bean.${fd.column_name}<#noparse>}</#noparse> and
                </if>
			</#list>
			<#if genField??>
			    <#list genField as fd>
	                <if test="page.bean.${fd.addname}!=null">
	                    ${fd.addnamed}.`${fd.addname}`=<#noparse>#{</#noparse>page.bean.${fd.addname}<#noparse>}</#noparse> and
	                </if>
				</#list>
			</#if>
        </trim>
    </select>
    
    <!-- 分页查询部分数据 -->
    <select id="query" resultType="${basePkg}.${beanName}.bean.${BeanName}">
        ${gsql}
        <trim prefix="where" prefixOverrides="and|or" suffixOverrides="and|or">
            <#list fields as fd>
                <if test="${fd.column_name}!=null">
                    t.`${fd.column_name}`=<#noparse>#{</#noparse>${fd.column_name}<#noparse>}</#noparse> and
                </if>
			</#list>
			<#if genField??>
			    <#list genField as fd>
	                <if test="${fd.addname}!=null">
	                    ${fd.addnamed}.`${fd.addname}`=<#noparse>#{</#noparse>${fd.addname}<#noparse>}</#noparse> and
	                </if>
				</#list>
			</#if>
        </trim>
    </select>
</mapper>