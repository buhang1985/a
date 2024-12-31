package iih.pe.pds.i;

import java.lang.reflect.InvocationTargetException;

import iih.pe.pds.pedsdiag.d.PeDsDiagDO;
import iih.pe.pds.pedsprodrel.d.PeDsProdRelDO;
import xap.mw.core.data.BizException;

public interface IPeDsMaintainService {
	
	/*
	 * 
	 * 
	 */
	PeDsProdRelDO[] computingRelAlg(String id_prod, String dt_begin, String dt_end, int alg) throws BizException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception;
	
	PeDsDiagDO[] computingDiagTree(String id_tree, String dt_begin, String dt_end, int alg) throws BizException, Exception;
}
