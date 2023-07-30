local myZset = KEYS[1] -- 取得 KEY 名稱
local myZval = ARGV[1] -- 取得 VALUE
local keyType = redis.call('type', myZset) -- 取得 KEY 的型別
keyType = keyType.ok or keyType -- 由 TABLE 取出結果
redis.log(redis.LOG_NOTICE, 'KeyType:'..keyType..', myZset:'..myZset..', myZval:'..myZval) -- 在日誌中印出
-- 若 KEY 存在但不為 ZSET 則回應錯誤
if keyType ~= 'none' and keyType ~= 'zset' then
  return 'error-輸入的 KEY 應為 zset 或不存在'
end
-- 若 VALUE 不存在 則回應錯誤
if myZval == nil then
  return 'error-未輸入 '..myZset..' 對應的值'
end
-- 若 VALUE 已加入 KEY 中，則回應重覆
local myScore = redis.call('zscore',myZset,myZval)
if myScore then
  return 'duplicated-'..myScore
end
-- 若 KEY 內的數目已達 3 則回應無額度
local count = redis.call('zcard', myZset)
if count >= 3 then
  return 'no quota'
end
-- 將 VALUE 加入 KEY 中，並回應其排名
redis.call('zadd',myZset,count+1, myZval)
return 'success-'..(count+1)