package com.sudao.cloud.module.idea.biz;

import com.sudao.cloud.module.base.config.enums.Deleted;
import com.sudao.cloud.module.base.dao.page.Page;
import com.sudao.cloud.module.idea.dao.dto.IdeaDTOExample;
import com.sudao.cloud.module.idea.service.IdeaService;
import com.sudao.cloud.module.idea.service.PlanContextService;
import com.sudao.cloud.module.idea.service.PlanService;
import com.sudao.cloud.module.idea.vo.req.IdeaQuery;
import com.sudao.cloud.module.idea.vo.resp.IdeaResp;
import com.sudao.cloud.module.praise.dao.dto.CollectPraiseDTOExample;
import com.sudao.cloud.module.praise.enums.ActionType;
import com.sudao.cloud.module.praise.enums.RelationType;
import com.sudao.cloud.module.praise.service.CollectPraiseService;
import com.sudao.cloud.module.praise.vo.resp.CollectPraiseResp;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * platform
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/10/26
 * @time: 下午11:08
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/26 下午11:08
 */
@Service
public class IdeaBiz {
    /******* Fields Area *******/
    private IdeaService ideaService;
    private PlanService planService;
    private PlanContextService planContextService;
    private CollectPraiseService collectPraiseService;

    /******* Construction Area *******/
    public IdeaBiz(@Autowired IdeaService ideaService,
                   @Autowired PlanService planService,
                   @Autowired PlanContextService planContextService,
                   @Autowired CollectPraiseService collectPraiseService) {
        this.ideaService = ideaService;
        this.planService = planService;
        this.planContextService = planContextService;
        this.collectPraiseService = collectPraiseService;
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


    /**
     * 根据筛选条件获得全部IDEA
     * @param query
     * @return
     */
    public Page<IdeaResp> findAllIdea(IdeaQuery query) {
        return this.ideaService.find(query);
    }

    /**
     * 根据筛选条件获得我发布的 IDEA
     * @param userId
     * @param query
     * @return
     */
    public Page<IdeaResp> findPublishIdea(Long userId, IdeaQuery query) {
        IdeaDTOExample example = new IdeaDTOExample();
        IdeaDTOExample.Criteria criteria = example.createCriteria();
        if(userId != null) {
            criteria.andOwnerIdEqualTo(userId);
        }
        example = buildQueryExample(query, example, criteria);
        return this.ideaService.findByExample(example, query);
    }


    /**
     *  根据筛选条件获得我收藏的 IDEA
     * @param userId
     * @param query
     * @return
     */
    public Page<IdeaResp> findForkIdea(String userId, IdeaQuery query) {
        CollectPraiseDTOExample praiseExample = new CollectPraiseDTOExample();
        CollectPraiseDTOExample.Criteria praiseCriteria = praiseExample.createCriteria();
        praiseCriteria.andActionTypeEqualTo(ActionType.ADD_COLLECT);
        praiseCriteria.andRelationTypeEqualTo(RelationType.IDEA);
        praiseCriteria.andDeletedEqualTo(Deleted.NORMAL.code());

        List<CollectPraiseResp> byExample = this.collectPraiseService.findByExample(praiseExample);
        return  null;
    }

    /**
     * 根据筛选条件获得贡献过的 IDEA
     * @param userId
     * @param query
     * @return
     */
    public Page<IdeaResp> findContributeIdea(String userId, IdeaQuery query) {
        return null;
    }


    /**
     * 构建 IdeaQuery Mysql Example 表达式
     * @param query IdeaQuery
     * @param example example
     * @param criteria criteria
     * @return example
     */
    private IdeaDTOExample buildQueryExample(IdeaQuery query, IdeaDTOExample example, IdeaDTOExample.Criteria criteria) {
        if (StringUtil.isNotEmpty(query.getKeyword())) {
            criteria.andTitleLike("%" + query.getKeyword() + "%");
        }
        if (query.getCategoryId() != null) {
            criteria.andCategoryIdEqualTo(query.getCategoryId());
        }
        if (query.getIdeaType() != null) {
            criteria.andIdeaTypeEqualTo(query.getIdeaType());
        }
        criteria.andDeletedEqualTo(Deleted.NORMAL.code());
        example.setOrderByClause("idea_id DESC");
        return example;
    }

}
