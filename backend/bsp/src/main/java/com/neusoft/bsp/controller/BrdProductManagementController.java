package com.neusoft.bsp.controller;

import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.mvoinfor.entity.*;
import com.neusoft.bsp.mvoinfor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//品牌商商品管理
@CrossOrigin
@RestController
@RequestMapping("/brdProductManagementController")
public class BrdProductManagementController {

    @Autowired
    ProProductService proProductService;

    @Autowired
    OfpOfferPriceService ofpOfferPriceService;

    @Autowired
    PckPackageInfoService pckPackageInfoService;

    @Autowired
    PdnProductDescriptionService pdnProductDescriptionService;

    @Autowired
    SpaSpecificAttributeService spaSpecificAttributeService;

    @Autowired
    SpvSpecificAttributeValueService spvSpecificAttributeValueService;

    @Autowired
    ImgImageService imgImageService;

    @RequestMapping("/searchPro")
    public BaseModelJson<List<ProProduct>> searchPro(@RequestBody int man_id){//前端传回当前用户的man_buyer_id
        List<ProProduct> resultList = proProductService.searchProduct(man_id);
        if (resultList.size() != 0){
            BaseModelJson<List<ProProduct>> result = new BaseModelJson();
            result.data = resultList;
            result.code = 200;
            return result;
        }else {
            BaseModelJson<List<ProProduct>> empty = new BaseModelJson();
            empty.data = null;
            empty.code = 200;
            return empty;
        }
    }

    @RequestMapping("/searchUnionInfo")
    public List<Map> searchUnionInfo(@RequestBody int man_id){
        List<ProProduct> resultPro = proProductService.searchProduct(man_id);//根据man_id查询对应的pro列表
        List<OfpOfferPrice> resultOfp;//用来记录每一个pro_id对应的多个ofp
        PckPackageInfo resultPak;//用来记录每一个pro_id对应的唯一pck
        PdnProductDescription resultPdn;//用来记录每一个pro_id对应的唯一pdn
        SpaSpecificAttribute resultSpa;//用来记录每一个pro_id对应的唯一spa
        SpvSpecificAttributeValue resultSpv;//用来记录每一个pro_id对应的唯一spv
        List<ImgImage> resultImg;//用来记录每一个pro_id对应的多个img


        List<Map> result = new ArrayList();//打包处理返回值(返回结果)

        int count = 0;//记录产品的个数

        if(resultPro != null){//如果有对应的pro
            for(ProProduct p: resultPro){
                Map tempResult = new HashMap();//用map存储当前打包信息

                resultOfp = ofpOfferPriceService.getOfpByProId(p.getPro_id());//给当前产品查询对应的ofp列表
                resultPak = pckPackageInfoService.searchPck(p.getPro_id());//给当前商品查询唯一的pck
                resultPdn = pdnProductDescriptionService.searchPdn(p.getPro_id());//给当前商品查询唯一的pdn
                resultSpa = spaSpecificAttributeService.searchSpa(p.getPro_id());//给当前商品查询唯一的spa
                if(resultSpa != null){//如果有spa
                    resultSpv = spvSpecificAttributeValueService.searchSpv(resultSpa.getSpa_id());//给当前商品查询唯一的spv
                }else {
                    resultSpv = null;
                }
                resultImg = imgImageService.searchImg(p.getPro_id());

                tempResult.put("pro",p);
                tempResult.put("ofp",resultOfp);
                tempResult.put("pak",resultPak);
                tempResult.put("pdn",resultPdn);
                tempResult.put("spa",resultSpa);
                tempResult.put("spv",resultSpv);
                tempResult.put("img",resultImg);


                result.add(count,tempResult);
                count++;
            }
        }else {//如果没查询到pro返回null
            result = null;
        }
        return result;
    }



}
