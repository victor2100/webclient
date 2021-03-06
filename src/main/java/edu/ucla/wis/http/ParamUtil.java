package edu.ucla.wis.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.ucla.wis.common.Log;
import edu.ucla.wis.common.Param;

public class ParamUtil {
	
	private Map<String, String> paramMap;
	
	public ParamUtil(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}
	
	public boolean doVariance() {
		return Boolean.parseBoolean(paramMap.get(Param.VARIANCE));
	}
	
	public boolean doConfidence() {
		return Boolean.parseBoolean(paramMap.get(Param.CONFIDENCE));
	}
	
	public boolean doExist() {
		return Boolean.parseBoolean(paramMap.get(Param.EXIST));
	}
	
	public boolean doQuantile() {
		return Boolean.parseBoolean(paramMap.get(Param.QUANTILE));
	}
	
	
	/**
	 * Return null if the format is invalid or violates some restrictions.
	 * 
	 * @return
	 */
	public List<String> getQueryList() {
		List<String> res = new ArrayList<String>();
		
		String tmp = paramMap.get(Param.QUERY);
		String[] sqls = tmp.split(";");
		
		for (String sql: sqls) {
			String query = sql.trim();
			if (query.length() < 3) {
			}
			else {
				res.add(query);
			}
		}
		
		return res;
	}
	
	/**
	 * Return null if the format is invalid or violates some restrictions.
	 * @return
	 */
	public String getExplainQueryString() {
		String query = paramMap.get(Param.QUERY).trim();
		query = query.replace(";", "");
		if (!query.startsWith("select")) {
			Log.log("only support select query for print plan");
			return null;
		}
		query = "explain " + query;
		return query;
	}
	
}