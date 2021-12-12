# SpringBoot_Pooja_Archana

1] signup -> POST http://localhost:8080/signup
{
    "name":"ds",
    "email":"akhil@gmail.com",
    "mobile":"8764567839",
    "gender":"male",
    "dob":"29-10-99",
    "password":"123456"
}

2] login -> POST http://localhost:8080/login
{
    "email":"suman@gmail.com",
    "password":"123456"
}

3] add category -> POST http://localhost:8080/admin/category
{
    "name":"Historical",
    "image":"historical image"
}

4] get all category -> http://localhost:8080/category

5] add story -> POST http://localhost:8080/admin/story
{
    "storyName":"Hanuman 1",
    "language":"English",
    "startYear":"1200 BC",
    "endYear":"1100 BC",
    "image":"hanuman 1 image",
    "categoryId":2
}

6] get all story -> http://localhost:8080/story

7] search story -> http://localhost:8080/story/search/{storyName}

8] get story by categoryId -> http://localhost:8080/story/{categoryId}

9] increment view of story -> PATCH http://localhost:8080/story/view/{storyId}

10] add chapter -> POST http://localhost:8080/admin/chapter
{
    "chapterName":"Hanuman1 chapter2",
    "description":"description",
    "serialNo":1,
    "image":"Chapter1 Hanuman2",
    "storyId":3
},

11] get chapter by storyId -> http://localhost:8080/chapter/{storyId}

12] add chapter html -> POST http://localhost:8080/admin/html/{chapterId}
{
    "content":"Hanuman1 chapter2 content2"
}

13] get all html by chapterId -> http://localhost:8080/html/{chapterId}
