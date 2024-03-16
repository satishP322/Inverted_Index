# Inverted_Index

   Elasticsearch uses a structure called an inverted index, which is designed to allow very fast full-text searches. An Inverted index is a database index storing a mapping from content, such as words or numbers, to its locations in a database, or in a document or a set of documents. The purpose of an inverted index is to allow a fast full-text search.
   
   Generally its very hard to find a specific file or file data on a local machine, which is very expensive in time. Especially windows slow search make things even more difficult. So, our application indexes list of all the files on your machine, builds the index over files and produces quick results. To keep it simple, this is an utility application, that provides a content based search over files on your local machine. Search has been optimized using inverted index!. 
   
   We have defined 3 types of search strategies here. these strategies help us to get the desired results. they are ANY, ALL and NONE
   
#### ANY 
   Produces a result of text files that contains any of the words from the search query.
   
#### ALL
   Produces a result of text files that contains all of the words from the search query.
   
#### NONE
   Produces a result of text files that contains none of the words from the search query.
   
  
