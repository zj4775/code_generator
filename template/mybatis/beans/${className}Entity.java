<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ${className}Entity{
	<#list table.columns as column>
	/** ${column.remarks} */
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower};
	</#list>

}


	



