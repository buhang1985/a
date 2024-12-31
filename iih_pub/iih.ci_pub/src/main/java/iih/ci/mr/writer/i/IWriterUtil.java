package iih.ci.mr.writer.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;

public interface IWriterUtil {
	
   public FArrayList2 findDataByPageIndex(String sqlStr,int pageSize,int pageIndex) throws BizException ;
   
   public FArrayList2 findDataAll(String sqlStr) throws BizException;
   
   public Boolean checkSqlValid(String sqlStr,Boolean isOnlySel) throws BizException;
   
   public int resultCount(String sqlStr, int pageSize) throws BizException;
   
   public String findDataScalar(String sqlStr) throws BizException;
}
