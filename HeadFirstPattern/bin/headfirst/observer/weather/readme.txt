DisplayElement
Observer
	CurrentConditionsDisplay
	ForecastDisplay
	HeatIndexDisplay
	StatisticsDisplay
Subject
	WeatherData
主程序
	WeatherStation
	WeatherStationHeatIndex
	
需要组合的点
	WeatherData里调用setMeasurements -> measurementsChanged -> notifyObservers
	构造函数StatisticsDisplay(WeatherData weatherData)
	subject有register和remove方法，变量是list
	每个Observer中都持有一个subject
	
