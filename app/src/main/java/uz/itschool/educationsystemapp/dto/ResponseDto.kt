package uz.itschool.educationsystemapp.dto

class ResponseDto<T> (
    private var code : Int,
    private var message : String,
    private var data : T,
    private var status : Boolean
)