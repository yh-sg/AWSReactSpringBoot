import axios from "axios";
import React, {useState, useEffect} from "react"
import Dropzone from "./Dropzone.jsx"

const UserProfiles = () => {

    const [userProfile, setUserProfile] = useState([]);

    const fetchUserProfiles = () =>{
        axios.get("http://localhost:8080/api/user-profile").then(res=>{
            console.log(res)
            setUserProfile(res.data);
        })
    }

    useEffect(()=>{
        fetchUserProfiles();
    }, []);

    return (
        userProfile.map((userProfile, index)=>{
            return(
                <div key={index}>
                    <br/>
                    <h1>{userProfile.userName}</h1>
                    <p>{userProfile.userId}</p>
                    <Dropzone />
                    <br/>
                </div>
            )
        })
    );
  }
  
  export default UserProfiles;