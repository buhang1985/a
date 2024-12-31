/*
 * 保存各种问卷内容，通过不同的函数，解析不同的录入DO，到统一的问卷内容保存DO
 * 
 * 
 */
package iih.pe.phm.i;

import java.lang.reflect.InvocationTargetException;

import iih.pe.phm.pepsychology.d.PePsychologyDO;
import iih.pe.phm.pesurveycma.d.PeSurveyCmaDO;
import xap.mw.core.data.BizException;

public interface IPeSurveryMaintainService{
	
    /*
     * 健康体检自测问卷（中华医学会健康管理学分会）
     * 将PeSurveyCmaDO中的数据保存到PeRstSurveryDO和PeRstSurveryKeyDO中
     * 2018-11-09, nielisheng
     */
	PeSurveyCmaDO saveSurveryCma(String id_pepsnappt, String id_perstsurvery, PeSurveyCmaDO survery) throws BizException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException;	
	

    /*
     * 心理评估问卷（SCL-90）
     * 将PePsychologyDO中的数据保存到PeRstSurveryDO和PeRstSurveryKeyDO中
     * 2018-11-09, nielisheng
     */
	PePsychologyDO savePsychology(String id_pepsnappt, String id_perstsurvery, PePsychologyDO survery) throws BizException;
} 
