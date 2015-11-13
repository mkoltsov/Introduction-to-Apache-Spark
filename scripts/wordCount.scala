val f = sc.textFile("../CHANGES.txt")

val wc = f.flatMap(l => l.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)

println(wc.toDebugString

wc.saveAsTextFile("wc_count")