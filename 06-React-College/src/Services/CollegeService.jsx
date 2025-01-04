import { useState } from "react";
import axios from "axios";

//To get all colleges information
export function useCollege() {

    const [allColleges, setAllColleges] = useState([]);
    const [error, setError] = useState(null);

    const fetchAllColleges = async () => {

        try {
            const response = await fetch(`${import.meta.env.VITE_HOST}/api/college/receive`);
            const data = await response.json();
            setAllColleges(data);
        } catch (error) {
            setError(error);
            console.error("Error fetching colleges:", error.message);
        }
    };

    return { allColleges, error, fetchAllColleges };
}

//To get all colleges with passed ID
export const useCollegeID = () => {

    const [College, setCollege] = useState(null);
    const [error, setError] = useState(null);

    const fetchSingleCollege = async (id) => {

        try {
            const response = await axios.get(`${import.meta.env.VITE_HOST}/api/college/${id}`);
            // Check if the response is valid, i.e., if the college exists
            if (response.status === 404) {
                throw new Error("College not found with ID" + id);
            }
            setCollege(response.data);
            setError(null);// Reset error if data is fetched successfully
        } catch (error) {
            setCollege(null);  // Reset college data if an error occurs
            setError(error.message || "An error occurred while fetching college data.");
            console.error(`Error fetching college with ID ${id}:`, error.message);
        }
    };

    return { College, error, fetchSingleCollege };
};

