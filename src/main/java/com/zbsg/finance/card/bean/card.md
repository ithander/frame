#select
*综合分页查询
select * from card where 1=1

<#if cardid??>
    and card_id=${cardId}
</#if>

<#if cardname??>
    and card_name=${cardName}
</#if>

<#if card_type??>
    and card_type=${cardType}
</#if>

<#if orderby??>
    order by ${orderby} ${sort?"cardid"}
<#else>
    order by card_id desc
</#if>