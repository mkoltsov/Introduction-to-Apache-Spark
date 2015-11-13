val data = 1 to 10000
val rdd = sc.parallelize(data)

println(rdd.filter(_ < 10).collect())