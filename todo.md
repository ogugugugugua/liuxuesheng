1. 需要弄两个列表分别存储所有有效的scheduleUUID和scheduleTypeUUID
2. 只要对于scheduleUUID或scheduleTypeUUID有增删改查的话，都需要对这两个列表进行更新
3. 每一个带有scheduleUUID和scheduleTypeUUID类成员的类，在进行增改时都需要进行scheduleUUID和scheduleTypeUUID的有效性判断
4. 接口幂等性保持问题需要解决：比如对于tranportation的新增，就可能会导致多个相同项
5. 所有的getByUuid/modify/delete方法都需要判断uuid是否为空，如果为空则直接返回null或者返回2，表示目标项找不到
6. 把所有的delete操作中的搜索操作都改为select count(1)+new Object，以减小数据库IO
7. 统一Exception处理
8. setImageNotVisible
9. 每一个小范围类在修改/新增时都需要检查大范围类的UUID是否存在且正确
10. 检查所有类的add方法是否会过度检查inspection，导致插入空字符串
11. 给restaurant加上getAvgPrice()
12. 添加限制规则，只有在大类存在时才能增加/修改小类，同9

13. 增加留学生和旅客的共通表： uuid,user_uuid,user_type,user_name;
    uniq_key_user_name;修改两个register方法，添加transactional操作