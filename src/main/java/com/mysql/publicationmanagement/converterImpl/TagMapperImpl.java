package com.mysql.publicationmanagement.converterImpl;

import com.mysql.publicationmanagement.converter.TagMapper;
import com.mysql.publicationmanagement.dto.TagDTO;
import com.mysql.publicationmanagement.model.Article;
import com.mysql.publicationmanagement.model.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

public class TagMapperImpl implements TagMapper {

    @Override
    public TagDTO toTagDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO(tag.getTagId(), tag.getTagName());
        List<Long> articleList = new ArrayList<>();
        for (Long articleId : articleList) {
            articleList.add(articleId);
        }
        tagDTO.setArticleID(articleList);
        return tagDTO;
    }

    @Override
    public Tag toTag(TagDTO tagDTO) {
        Tag tag= new Tag();
        tag.setTagId(tagDTO.getTagId());
        tag.setTagName(tagDTO.getTagName());
        Article article=new Article();
        List<Article> articleList=new ArrayList<>();
        for(Long articleID : tagDTO.getArticleID()){
            article.setArticleId(articleID);
            articleList.add(article);
        }
        tag.setArticles(articleList);

        return tag;
    }


    @Override
    public List<TagDTO> toTagDTOList(List<Tag> tagList) {
        List<TagDTO> dtoList=new ArrayList<>();
        for(Tag tag: tagList){

            dtoList.add(toTagDTO(tag));
        }
        return dtoList;
    }


    @Override
    public List<Tag> toTagList(List<TagDTO> tagDTO) {
        List<Tag> tagList=new ArrayList<>();
        for(TagDTO dto: tagDTO){

            tagList.add(toTag(dto));
        }
        return tagList;
    }
}
