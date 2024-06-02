package fpoly.giapdqph34273.lab7_kot104.model

data class Movie(
    val title: String,
    val duration: String,
    val releaseDate: String,
    val posterUrl: String,
    val genre: String,
    val shotDescription: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie(
                "The Shawshank Redemption",
                "142",
                "14/10/1994",
                "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg",
                "Drama",
                "\"The Shawshank Redemption\" là một bộ phim Mỹ ra mắt" +
                        " năm 1994, dựa trên truyện ngắn \"Rita Hayworth and Shawshank " +
                        "Redemption\" của Stephen King. Phim kể về Andy Dufresne (do Tim" +
                        " Robbins thủ vai), một nhân viên ngân hàng bị kết án tù chung" +
                        " thân vì tội giết vợ và người tình của cô. Tại nhà tù Shawshank," +
                        " anh kết bạn với một tù nhân lâu năm tên là Ellis \"Red\" Redding" +
                        " (do Morgan Freeman thủ vai). Bộ phim khai thác sâu sắc những khía" +
                        " cạnh về hy vọng, tình bạn và sự kiên cường của con người, cùng với" +
                        " những khó khăn và bất công trong hệ thống nhà tù. Với diễn xuất tuyệt" +
                        " vời và câu chuyện đầy cảm xúc, \"The Shawshank Redemption\" đã trở thành" +
                        " một trong những bộ phim được yêu thích và tôn vinh nhất mọi thời đại."
            ),

            Movie(
                "The Godfather",
                "175",
                "24/03/1972",
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
                "Crime",
                "\"The Godfather\" là một bộ phim tội phạm kinh điển của Mỹ, ra " +
                        "mắt năm 1972, do Francis Ford Coppola đạo diễn và dựa trên tiểu thuyết " +
                        "cùng tên của Mario Puzo. Phim kể về gia đình tội phạm Corleone, tập " +
                        "trung vào sự chuyển giao quyền lực từ ông trùm Vito Corleone (do Marlon " +
                        "Brando thủ vai) sang con trai út Michael Corleone (do Al Pacino thủ vai)." +
                        " Câu chuyện mô tả sâu sắc về thế giới ngầm của mafia, với những mưu mô, " +
                        "đấu đá quyền lực và những quyết định tàn nhẫn. \"The Godfather\" nổi bật " +
                        "với diễn xuất xuất sắc, kịch bản chặt chẽ và sự chỉ đạo tài tình, trở " +
                        "thành một trong những tác phẩm điện ảnh vĩ đại nhất trong lịch sử, ảnh " +
                        "hưởng sâu rộng đến văn hóa đại chúng và ngành công nghiệp điện ảnh."
            ),
            Movie(
                "The Dark Knight",
                "152",
                "18/07/2008",
                "https://m.media-amazon.com/images/S/pv-target-images/e9a43e647b2ca70e75a3c0af046c4dfdcd712380889779cbdc2c57d94ab63902.jpg",
                "Action",
                "\"The Dark Knight\" là bộ phim siêu anh hùng ra mắt năm 2008 do " +
                        "Christopher Nolan đạo diễn. Phim có Christian Bale trong vai Batman và " +
                        "Heath Ledger trong vai Joker. Câu chuyện xoay quanh cuộc chiến của " +
                        "Batman chống lại Joker, kẻ gây ra hỗn loạn và thách thức đạo đức của " +
                        "anh. Với diễn xuất xuất sắc, đặc biệt là của Ledger, và kịch bản thông " +
                        "minh, phim được coi là một trong những tác phẩm siêu anh hùng hay " +
                        "nhất mọi thời đại."
            ),
        )
    }
}