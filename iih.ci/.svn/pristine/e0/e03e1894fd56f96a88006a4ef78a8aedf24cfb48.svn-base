package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;


public class ExecuteQueryBP {
	
public  FArrayList2  exe(String sql) throws BizException  {
		
		DAFacade da=new DAFacade();
		FArrayList2 fa=new FArrayList2();
			List<HashMap<String, Object>>  result=(List<HashMap<String, Object>> )da.execQuery(sql, new MapListHandler());
            if(result!=null) {
            	for (HashMap<String, Object> hashMap : result) {
					FMap2 m=new FMap2();
					for (String key : hashMap.keySet()) {
						m.put(key, hashMap.get(key));
					}
					fa.add(m);
				}
            }
			
			return fa;

	}

}
