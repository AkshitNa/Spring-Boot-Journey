import React, { useState } from "react";
import { useCollegeID } from "../Services/ServiceIndex";

function CollegeSelector() {

    const [inputId, setInputId] = useState(""); // Store user-entered college ID
    const { College, error, fetchSingleCollege } = useCollegeID();//using Custom Hooks

    // Handle college ID input
    const handleInputChange = (event) => {
        setInputId(event.target.value); // Update state with user input
    };

    // Handle button click to fetch college details
    const handleButtonClick = () => {
        if(inputId == "" || isNaN(inputId)){
            alert("Write Valild ID!!")
        }
       
        fetchSingleCollege(inputId); // Fetch data for the entered college ID
    };

    return (
        <>
         <h1 className="text-xl font-semibold mb-4 text-center mt-3">College Details</h1>
         <div className="flex flex-col items-center container">
           
            {/* Input field to enter college ID */}
            <div className="flex items-baseline space-x-4">
                <label htmlFor="collegeInput" className="block mb-2">Enter College ID:</label>
                <input
                    type="text"
                    id="collegeInput"
                    value={inputId}
                    onChange={handleInputChange}
                    className="p-2 border mb-4 w-1/4 border-black bg-blue-400"
                />
                <button
                    onClick={handleButtonClick}
                    className="p-2 bg-green-500 text-white rounded hover:bg-green-600"
                >
                    Click
                </button>
            </div>

             {/* Handle errors or data not found */}
             {error && (
                <div className="text-red-700 mt-4">DATA NOT AVAILABLE!!</div>
            )}

            {/* Show the selected college details */}
            {College && (
                <div className="college-details mt-4">
                    <h2 className="font-medium">College Name: {College.collegeName}</h2>
                    <p><strong>Location:</strong> {College.location}</p>
                </div>
            )}
        </div>
        </>
    );
}

export default CollegeSelector;
