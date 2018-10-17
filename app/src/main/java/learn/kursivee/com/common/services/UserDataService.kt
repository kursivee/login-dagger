package learn.kursivee.com.common.services

class UserDataService(var dependencyService: DependencyService){
    var name = ""

    fun getSomething() : String {
        return dependencyService.text
    }
}