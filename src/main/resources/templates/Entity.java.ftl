package ${package}.modules.${moduleName}.entity<#if subModuleName??>.${subModuleName}</#if>;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * ${tableComment}
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("${tableName}")
public class ${ClassName}Entity implements Serializable{
	private static final long serialVersionUID = 1L;

<#list columnList as column>
	<#if column.columnComment!?length gt 0>
	/**
	* ${column.columnComment}
	*/
	</#if>
	private ${column.arrtType} ${column.columnName};

</#list>
}