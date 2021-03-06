import axios from "axios";
import React, {useCallback} from "react"
import {useDropzone} from 'react-dropzone'

function Dropzone({userId}) {
    const onDrop = useCallback(acceptedFiles => {
      // Do something with the files
      const file = acceptedFiles[0];
      console.log(file);
      let formData = new FormData();
      formData.append("file", file);

      axios.post(
          `http://localhost:8080/api/user-profile/${userId}/image/upload`,
          formData,
          {
              headers:{
                  "Content-Type": "multipart/form-data"
              }
          }
        ).then(()=>{
            console.log("file uploaded successfully")
        }).catch(e=>{
            console.log(e);
        })
    }, [])

    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})
  
    return (
      <div {...getRootProps()}>
        <input {...getInputProps()} />
        {
          isDragActive ?
            <p>Drop the image here ...</p> :
            <p>Drag 'n' drop image, or click to select image</p>
            
        }
      </div>
    )
  }

export default Dropzone;