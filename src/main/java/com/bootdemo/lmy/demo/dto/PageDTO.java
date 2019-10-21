package com.bootdemo.lmy.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李
 * @create 2019/10/3 16:27
 */
@Data
public class PageDTO {
    private List<QuestionDTO> questionDTOList;
    private boolean isFirstPage =true;
    private boolean isEndPage=false;
    private boolean nextPage=true;
    private boolean previousPage=false;
    private int totalPage;
    private int page;
    private List<Integer> pageNum=new ArrayList<Integer>();

    public void setPage(int totalPage, Integer page, Integer size) {
        if(page>totalPage){
            nextPage=false;
            isEndPage=true;
            pageNum.add(page);
            return;
        }
        this.page=page;
        this.totalPage=totalPage;
        isFirstPage = page==1?true:false;
        isEndPage = page ==totalPage?true:false;
        previousPage = page>1?true:false;
        if(page<totalPage && totalPage>1){
            nextPage=true;
        }else{
            nextPage=false;
        }
        pageNum.add(page);
        int t=1;
        for(int i=1;i<5;i++){
            if(page==totalPage){
                if(page-i>1){
                    pageNum.add(0,page-i);
                    continue;
                }
            }
            if(page-i>0 && pageNum.size()<4){
                pageNum.add(0,page-i);
                continue;
            }
            if(page+t<=totalPage) {
                pageNum.add(page + (t++));
                continue;
            }
    }
    }
}
